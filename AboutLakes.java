/*Вариант 10
Разработать класс для хранения информации об озерах:
Название, место_расположения, площадь
и реализовать алгоритм работы с массивом данных объектов, в котором
требуется:
– определить самое большое озеро;
– подсчитать количество озер с площадью меньше средней;
– упорядочить список по названиям;
– организовать поиск по названию озера, исправление одного из полей и
вывод полной информации об озере после редактирования.*/

import java.util.Scanner;

class Lake{
    String name, location;
    int area;
}

public class AboutLakes {
    static Scanner sc;

    public static Lake[] fillLakes(int count){
        Scanner sc=new Scanner(System.in,"cp1251");
        Lake[] lakes = new Lake[count];

        System.out.println("Введите информацию об озерах: ");
        for (int i = 0; i < lakes.length; i++){
            lakes[i] = new Lake();
            System.out.println("Name: ");
            lakes[i].name = sc.nextLine();
            System.out.println("Location: ");
            lakes[i].location = sc.nextLine();
            System.out.println("Area: ");
            lakes[i].area = sc.nextInt();
            sc.nextLine();
        }
        return lakes;
    }

    public static void printInfoLakes(Lake[]lakes) {
        for (int i = 0; i < lakes.length; i++) {
            System.out.println("Name: " + lakes[i].name +
                    "Location: " + lakes[i].location +
                    "Area " + lakes[i].area);
        }
    }
    public static void findBiggestLake(Lake mountains){
        System.out.println("Name: " + mountains.name +
                "Location: " + mountains.location +
                "Area: " + mountains.area);
    }
    public static int NomMax(Lake[] lakes) {
        int nommax = 0;
        double max = lakes[nommax].area;
        for (int i = 0; i < lakes.length; i++)
            if (lakes[i].area > max) {
                max = lakes[i].area;
                nommax = i;
            }
        return nommax;
    }

    public static void findLakeSmallerMiddle(Lake[] lakes){
        double average =0;
        if (lakes.length>0){
            double sum=0;
            for (int i=0; i< lakes.length; i++){
                sum =sum+lakes[i].area;
            }
            average=sum/lakes.length;
        }
        for(int i = 0; i< lakes.length;i++){
            if(lakes[i].area<average){
                System.out.println("Name: " + lakes[i].name +
                        "Location: " + lakes[i].location +
                        "Height: " + lakes[i].area);
            }
        }
    }

    public  static void sortName(Lake[]lakes){
        for(int i = 0; i < lakes.length-1; i++)
            for(int j =0; j < lakes.length-1-i; j++)
                if(lakes[j].area>lakes[j+1].area){
                    Lake rab=lakes[j];
                    lakes[j]=lakes[j+1];
                    lakes[j+1]=rab;
                }
    }

    public static Lake findForName(Lake mountain[],String name){
        int n = -1;
        for(int i =0; i < mountain.length; i++)
            if(name.equals(mountain[i].name))
                n=i;
        if(n!=-1){
            return mountain[n];
        }
        else return null;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Count: ");
        int count = sc.nextInt();
        Lake[]lakes= fillLakes(count);

        printInfoLakes(lakes);

        int nommax = NomMax(lakes);
        System.out.println("\nThe biggest lake: ");
        findBiggestLake(lakes[nommax]);

        System.out.println("\nMountains Smaller Average: ");
        findLakeSmallerMiddle(lakes);

        sortName(lakes);
        System.out.println("\nSorted list by top: ");
        printInfoLakes(lakes);

        System.out.println("\nMountain search \n Input mountain's name: ");
        sc.nextLine();
        String sname=sc.nextLine();
        Lake sfind = findForName(lakes, sname);
        if(sfind!=null){
            findBiggestLake(sfind);
        } else {
            System.out.println("Error!");
        }
    }
}
