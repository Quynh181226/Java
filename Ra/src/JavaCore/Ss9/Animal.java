package JavaCore.Ss9;

class Animal {
    void sound(){
        System.out.println("Sound");
    }
    void feed(){
        System.out.println("Feeding");
    }
}

class Dog extends  Animal{
    @Override
    void sound(){
        System.out.println("Gau gau");
    }
    void piss(){
        System.out.println("Dang di dai");
    }

}

class Cat extends  Animal{
    @Override
    void sound(){
        System.out.println("Meo meo");
    }
}