/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`;
}
function exChart( exLabels=[], exInfo=[]) {
    let colors = []
    for(i=0; i<exInfo.length; i++){
        colors.push(generateColor());
    }
    const data = {
        labels: exLabels,
        datasets: [{
                label: 'Bao cao tong chi theo tung danh muc',
                data: exInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };

    const ctx = document.getElementById("myExpStaChart").getContext("2d");
    new Chart(ctx, config);
}
function expenseChart( exLabels2=[], exInfo2=[]) {
    let colors = []
    for(i=0; i<exInfo2.length; i++){
        colors.push(generateColor());
    }
    const data = {
        labels: exLabels2,
        datasets: [{
                label: 'Bao cao theo thang trong quy',
                data: exInfo2,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data,
    };

    const ctx = document.getElementById("myExpStaChart2").getContext("2d");
    new Chart(ctx, config);
}
