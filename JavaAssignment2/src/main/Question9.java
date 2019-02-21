package main;

public class Question9 {
    /*Design classes having attributes for furniture where there are wooden chairs and tables,
    metal chairs and tables. There are stress and fire tests for each products.*/
    public static void main(String[] args) {

    }
}

class WoodenChair extends Chair {

    @Override
    public void stressTest() {

    }

    @Override
    public void fireTest() {

    }
}

class WoodenTable extends Table {

    @Override
    public void stressTest() {

    }

    @Override
    public void fireTest() {

    }
}

class MetalChair extends Chair{

    @Override
    public void stressTest() {

    }

    @Override
    public void fireTest() {

    }
}

class MetalTable extends Table{

    @Override
    public void stressTest() {

    }

    @Override
    public void fireTest() {

    }
}

interface Furniture {
    public void stressTest();

    public void fireTest();
}

abstract class Chair implements Furniture {

}

abstract class Table implements Furniture {

}
