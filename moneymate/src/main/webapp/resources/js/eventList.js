/* document.getElementById("event1").addEventListener("click", () => {
    var href = element.getAttribute('data-href');
    if (href) {
        location.href = href;
    }
})
 */

var stage, 

numParticles = 30, 
particlesArray = [], 
colourArray = ['#18DD00', '#E1C829', '#2FB5F3', '#FC82C3' , '#1E023F'];

function init() 
{ 
stage = new createjs.Stage('canvas'); 
stage.addEventListener('stagemousemove', moveHandler); 
resizeCanvas(); // 초기 캔버스 크기 설정
createjs.Ticker.addEventListener('tick', tick); 
createjs.Ticker.setFPS(60); 
} 

function moveHandler() 
{ 
if(particlesArray.length < numParticles) 
{ 
    var g = new createjs.Graphics(); 
    g.beginFill(colourArray[Math.floor(Math.random() * colourArray.length)]); 
    g.drawRect(0,0,10,10); 

    var square = new createjs.Shape(g); 
    square.x = stage.mouseX; 
    square.y = stage.mouseY; 
    square.alpha = getRandom(0.5,0.9); 
    square.scaleX = getRandom(0.5,0.9); 
    square.scaleY = getRandom(0.5,0.9); 
    square.rotation = getRandom(0,360); 
    square.xVel = getRandom(-4,4); 
    square.yVel = getRandom(-4,4); 
    stage.addChild(square); 
    particlesArray.push(square); 

    stage.update(); 
} 
} 

function tick() 
{ 
for(var i = 0; i < particlesArray.length; i++){ 

    var particle = particlesArray[i]; 
    particle.x += particle.xVel; 
    particle.y += particle.yVel; 
    particle.alpha -= 0.06; 

    if(particle.alpha <= 0){ 
        particlesArray.splice(i, 1); 
        stage.removeChild(particle); 
        stage.update(); 
    } 

} 
} 

function getRandom(min, max) 
{
return min + (Math.random() * (max - min));
}

function resizeCanvas() {
    var canvas = document.getElementById('canvas');
    var width = window.innerWidth; // 창의 너비
    var height = window.innerHeight; // 창의 높이
    canvas.width = width;
    canvas.height = height;
    stage.canvas.width = width;
    stage.canvas.height = height;
}


