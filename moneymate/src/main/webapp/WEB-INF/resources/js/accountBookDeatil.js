window.onload = function () {
    pieChartDraw();
}




let pieChartData = {
    labels: ['식비', '교통비', '주거비', '관리비', '유흥', '생필품'],
    datasets: [{
        data: [10, 20, 50, 5, 10, 5],
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
    }] 
};

let pieChartDraw = function () {
    let ctx = document.getElementById('pieChartCanvas').getContext('2d');
    
    window.pieChart = new Chart(ctx, {
        type: 'pie',
        data: pieChartData,
        options: {
            responsive: false
        }
    });
};