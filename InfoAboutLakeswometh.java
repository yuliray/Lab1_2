import java.util.Scanner;

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

class Lake {
    String name,location;
    double area;
}
public class InfoAboutLakeswometh {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("count:");
        int count = sc.nextInt();
        Lake[] lakes= new Lake [count];
        for(int i = 0; i < lakes.length; i++){
            sc.nextLine();
            lakes[i] = new Lake();
            System.out.println("Name: ");
            lakes[i].name = sc.nextLine();
            System.out.println("Location: ");
            lakes[i].location = sc.nextLine();
            System.out.println("Area: ");
            lakes[i].area = sc.nextInt();
        }
        sc.nextLine();

        System.out.println("info about lakes: ");
        for(int i = 0; i < lakes.length; i++){
            System.out.println("Name = " +  lakes[i].name +
                    " Location = " + lakes[i].location +
                    " Area = " + lakes[i].area);
        }
        int nhighest = 0;
        double highest = lakes[nhighest].area;
        for(int i = 1; i < lakes.length; i++){
            if(lakes[i].area > highest){
                highest = lakes[i].area;
                nhighest = i;
            }
        }
        System.out.println("The biggest mountain: ");
        System.out.println("Name = " +lakes[nhighest].name +
                " Location = " +lakes[nhighest].location +
                " Area = " + lakes[nhighest].area);
        for(int i = 0; i < lakes.length - 1; i++)
            for(int j = 0; j < lakes.length - 1 - i; j++)
                if(lakes[j].area > lakes[j + 1].area){
                    Lake rab = lakes[j];
                    lakes[j] = lakes[j+1];
                    lakes[j+1] = rab;
                }
        double average = 0;
        if (lakes.length>0){
            double sum=0;
            for(int i=0; i< lakes.length; i++){
                sum=sum+lakes[i].area;
            }
            average=sum/lakes.length;
        }
        System.out.println("Mountain smaller average");
        for(int i = 0; i < lakes.length; i++){
            if(lakes[i].area < average)
                System.out.println("Name = " +lakes[i].name +
                        " Location = " +lakes[i].location +
                        " Area = " + lakes[i].area);
        }

        System.out.println("to the top:");
        for(int i = 0; i < lakes.length; i++){
            System.out.println("Name = " +lakes[i].name +
                    " Location = " +lakes[i].location +
                    " Area = " + lakes[i].area);
        }

        System.out.println("Type searchName");
        String nameSearch = sc.nextLine();
        int nomS = -1;
        for(int i = 0; i < count; i++){
            if(lakes[i].name.equals(nameSearch)){
                nomS = i;
            }
        }
        if(nomS!= -1){
            System.out.println("input index");
            System.out.println("name, location, area");
            String strPole = sc.nextLine();
            switch (strPole){
                case "name":{
                    System.out.println("input new name");
                    String newName = sc.nextLine();
                    lakes[nomS].name = newName;
                    break;
                }
                case "location":{
                    System.out.println("input new location");
                    String newLocation = sc.nextLine();
                    lakes[nomS].location = newLocation;
                    break;
                }
                case "area":{
                    System.out.println("input new area");
                    int newHeight = sc.nextInt();
                    lakes[nomS].area = newHeight;
                    break;
                }
                default:{
                    System.out.println("error");
                }
            }
            System.out.println("new version");
            System.out.println("Name = " + lakes[nomS].name +
                    " Location = " + lakes[nomS].location +
                    " Area = " + lakes[nomS].area);
        }
        else{
            System.out.println("error");
        }
    }
}