// 추후 DB를 이용할 때 사용하는 dao입니다.
// 어떤 DB를 구축할지에 대해 생각해봅시다.

package com.bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.dto.Summoner;

public class SearchLogDao {
	private static String dburl = "jdbc:mysql://localhost:3306/searchlog?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "ventulus95";
	private static String dbpasswd = "changsup95";
	
	public int addSearchLog(Summoner summoner) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO search (profileIconId, name, puuid, id, accountId ) VALUES ( ?, ?, ?, ?, ? ) ON DUPLICATE KEY UPDATE searchdate = VALUES(searchdate);";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, summoner.getProfileIconId());
			ps.setString(2, summoner.getName());
			ps.setString(3, summoner.getPuuid());
			ps.setString(4, summoner.getId());
			ps.setString(5, summoner.getAccountId());
			
			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public List<Summoner> getSearchLogs() {
		List<Summoner> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT profileIconId,name FROM search order by searchdate desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String name = rs.getString("name");
					int profileIconId = rs.getInt("profileIconId");
					Summoner summoner = new Summoner();
					summoner.setProfileIconId(profileIconId);
					summoner.setName(name);
					list.add(summoner); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
}
