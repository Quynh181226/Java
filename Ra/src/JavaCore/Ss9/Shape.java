package JavaCore.Ss9;

class Shape {
    double area(double n){
        return 0;
    }
    double area(double w, double l){
        return 0;
    }
}

class Circle extends Shape{
    @Override
    double area(double n){
        return 3.14 * n * n;
    }

}

class Rectangle extends Shape{
    @Override
    double area(double l , double w){
        return  l * w;
    }
}

