'use strict';

class Circle {
    constructor(x, y, r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    containsPoint(point){
        return Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2) <= Math.pow(this.r, 2);
    }

    getRadius(){
        return this.r;
    }
}

class Point {
    constructor(x, y){
        this.x = x;
        this.y = y;
    }

    getX(){
        return this.x;
    }

    getY(){
        return this.y;
    }

    static generatePoint(x, y){
        return new Point(Math.random()*x, Math.random()*y);
    }
}

class Square {
    constructor(x, y, s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    getX(){
        return this.x;
    }

    getY(){
        return this.y;
    }

    getSide(){
        return this.s;
    }
}

class MonteCarloPI {

    constructor(shapeGenerator, canvas){
        this.circle = shapeGenerator.getCircle();
        this.square = shapeGenerator.getSquare();
        this.canvas = canvas;
    }

    getPIApproximation(pointsInCircle, totalPoints) {
        return 4 * pointsInCircle / totalPoints;
    }

    *runPISimulation(){
        let pointsCounter = 0;
        let pointsInCircle = 0;
        for(let i=0; i<Infinity; i++){
            const point = Point.generatePoint(this.square.getSide(), this.square.getSide());
            pointsCounter++;
            pointsInCircle = this.updateGraph(point, pointsInCircle);
            this.updateNumbers(pointsInCircle, pointsCounter);
            yield this.getPIApproximation(pointsInCircle, pointsCounter).toFixed(3);
        }
        return -1;
    }

    updateGraph(point, pointsInCircle) {
        if (this.circle.containsPoint(point)) {
            pointsInCircle++;
            this.canvas.drawPoint(point, "green");
        }
        else {
            this.canvas.drawPoint(point, "red");
        }
        return pointsInCircle;
    }

    updateNumbers(pointsInCircle, pointsCounter){
        const myCircle = document.getElementById("myCircle");
        const mySquare = document.getElementById("mySquare");
        myCircle.textContent = "Total points in circle: " + pointsInCircle;
        mySquare.textContent = "Total points in square: " + pointsCounter;
    }
}

class ShapeGenerator {
    constructor(xLeftTop, yLeftTop, radius){
        this.circle = new Circle(xLeftTop+radius, yLeftTop+radius, radius);
        this.square = new Square(xLeftTop, yLeftTop, 2*radius);
    }

    getSquare(){
        return this.square;
    }

    getCircle(){
        return this.circle;
    }
}

class Canvas {
    constructor(canvas, shapeGenerator){
        this.canvas = canvas;
        this.shapeGenerator = shapeGenerator;
        this.canvas.width = shapeGenerator.getSquare().getSide();
        this.canvas.height = shapeGenerator.getSquare().getSide();
        this.ctx = this.canvas.getContext("2d");
        this.drawCircle("#0080ff")
    }

    drawCircle(color){
        const radius = this.shapeGenerator.getCircle().getRadius();
        this.ctx.beginPath();
        this.ctx.arc(radius, radius, radius, 0, 2*Math.PI);
        if(color != undefined){
            this.ctx.strokeStyle = color;
        }
        this.ctx.stroke();
        this.ctx.closePath();
    }

    drawPoint(point, color){
        this.ctx.beginPath();
        this.ctx.arc(point.getX(), point.getY(), 1, 0, 2*Math.PI);
        this.ctx.fillStyle = color;
        this.ctx.fill();
        this.ctx.closePath();
    }
}

const updatePIValue = () => {
    const PIValue = document.getElementById("myPI");
    PIValue.textContent = "PI value: " + PIGenerator.next().value;
}
const onSpeedChange = (id) => {
    updateTime(id);
    clearInterval(interval);
    interval = setInterval(updatePIValue, time);
}
const updateTime = (id) => {
    if (id === "speedUp") {
        if (time >= 100) {
            time -= 100;
        }
    }
    else {
        time += 500;
        if (time > 1000 * 60) {
            time = 500;
        }
    }
}
const radius = 300;
const shapeGenerator = new ShapeGenerator(0, 0, radius);
const myCanvas = document.getElementById("myCanvas");
const canvas = new Canvas(myCanvas, shapeGenerator);
const monteCarloPI = new MonteCarloPI(shapeGenerator, canvas);
const PIGenerator = monteCarloPI.runPISimulation();
let time = 500;
let interval = setInterval(updatePIValue, time);


