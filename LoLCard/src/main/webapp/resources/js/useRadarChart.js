/**
 * 
 */

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var marksData = {
		labels : ["행복", "HR제도", "사무환경", "윤리경영", "업무"],
		datasets:[{
			label : "전사",
			backgroundColor: "transparent",
			borderColor: "rgba(200,0,0,0.6)",
			fill : false,
			radius : 6,
			pointRadius : 6,
			pointBorderWidth : 3,
			pointBackgroundColor : "orange",
			pointBorderColor : "rgba(200,0,0,0.6)",
			pointHoverRadius:10,
			data : [3, 4, 3.3, 3, 3]
		}, {
			label : "우리조직",
			backgroundColor: "transparent",
			borderColor: "rgba(200,0,0,0.6)",
			fill : false,
			radius : 6,
			pointRadius : 6,
			pointBorderWidth : 3,
			pointBackgroundColor : "cornflowerblue",
			pointBorderColor : "rgba(0,0,200,0.6)",
			pointHoverRadius:10,
			data : [3.3, 3, 2.2, 3, 4]
		}]
};

var chartOptions = {
		scale : {
			gridLines:{
				color : "black",
				lineWidth : 3
			},
			angleLines : {
				display : false
			},
			ticks : {
				beginAtZero : true,
				min : 0,
				max : 5,
				stepSize : 1
			},
			pointLabels : {
				fontSize : 18,
				fontColor: "green"
			}
		},
		legend : {
			position : 'left'
		}
};

var radarChart = new Chart(marksCanvas, {
	type : 'radar',
	data : marksData,
	options : chartOptions
	
});



































