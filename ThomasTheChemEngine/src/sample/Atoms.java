package sample;

import java.util.ArrayList;

public class Atoms {

    public final int len = 60;
    private Atom[] atoms = new Atom[len];

    public Atoms(){
        initAtom();
    }
    //Little init, to initialize all values
    private void initAtom(){
        int i = 0;
        atoms[i++] = new Atom("H",1,1.008, 1,0,0,0);
        atoms[i++] = new Atom("He",2,4.003,2,0,0,0);
        atoms[i++] = new Atom("Li",3,6.941,3,0,0,0);
        atoms[i++] = new Atom("Be",4,9.012,4,0,0,0);
        atoms[i++] = new Atom("B",5,10.81,1,0,0,0);
        atoms[i++] = new Atom("C",6,12.01,2,0,0,0);
        atoms[i++] = new Atom("N",7,14.01,4,3,0,0);
        atoms[i++] = new Atom("O",8,16.01,4,4,0,0);
        atoms[i++] = new Atom("F",9,18.00,4,5,0,0);
        atoms[i++] = new Atom("Ne",10,20.18,4,6,0,0);

        atoms[i++] = new Atom("Na",11,22.98,5,6,0,0);
        atoms[i++] = new Atom("Mg",12,24.31,6,6,0,0);
        atoms[i++] = new Atom("Al",13,26.98,6,7,0,0);
        atoms[i++] = new Atom("Si",14,28.09,6,8,0,0);
        atoms[i++] = new Atom("P",15,30.97,6,9,0,0);
        atoms[i++] = new Atom("S",16,32.07,6,10,0,0);
        atoms[i++] = new Atom("Cl",17,35.45,6,11,0,0);
        atoms[i++] = new Atom("Ar",18,39.95,6,12,0,0);
        atoms[i++] = new Atom("K",19,39.1, 7,12, 0,0);

        atoms[i++] = new Atom("Ca",20,40.1,8,12,0,0);
        atoms[i++] = new Atom("Sc",21,45.0,8,12,1,0);
        atoms[i++] = new Atom("Ti",22,47.87,8,12,2,0);
        atoms[i++] = new Atom("V",23,50.94,8,12,3,0);
        atoms[i++] = new Atom("Cr",24,52.0,8,12,4,0);
        atoms[i++] = new Atom("Mn",25,54.94,7,12,5,0);
        atoms[i++] = new Atom("Fe",26,55.86,8,12,6,0);
        atoms[i++] = new Atom("Co",27,58.93,8,12,7,0);
        atoms[i++] = new Atom("Ni",28,58.70,8,12,8,0);
        atoms[i++] = new Atom("Cu",29,63.557,7,12,10,0);
        ;
        atoms[i++] = new Atom("Zn",30,65.39,8,12,10,0);
        atoms[i++] = new Atom("Ga",31,69.72,8,13,10,0);
        atoms[i++] = new Atom("Ge",32,72.64,8,14,10,0);
        atoms[i++] = new Atom("As",33,74.92,8,15,10,0);
        atoms[i++] = new Atom("Se",34,78.96,8,16,10,0);
        atoms[i++] = new Atom("Br",35, 79.90,8,17,10,0);
        atoms[i++] = new Atom("Kr", 36,83.8,8,18,10,0);
        atoms[i++] = new Atom("Rb",37,85.47,9,18,10,0);
        atoms[i++] = new Atom("Sr",38,87.62,10,18,10,0);
        atoms[i++] = new Atom("Y",39,88.91,10,18,11,0);

        atoms[i++] = new Atom("Zr",40, 91.22,10,18,12,0);
        atoms[i++] = new Atom("Nb",41,92.91,9,18,14,0);
        atoms[i++] = new Atom("Mo",42, 95.94,9,18,15,0);
        atoms[i++] = new Atom("Tc",43, 98.0,10,18,15,0);
        atoms[i++] = new Atom("Ru",44, 101.17,9,18,17,0);
        atoms[i++] = new Atom("Rh",45, 102.91,9,18,18,0);
        atoms[i++] = new Atom("Pd",46, 106.42,8,18,20,0);
        atoms[i++] = new Atom("Ag",47,107.87,9,18,20,0);
        atoms[i++] = new Atom("Cd",48,112.41,10,18,20,0);
        atoms[i++] = new Atom("In",49, 114.82,10,19,20,0);

        atoms[i++] = new Atom("Sn",50,118.71,10,20,20,0);
        atoms[i++] = new Atom("Sb",51, 121.76,10,21,20,0);
        atoms[i++] = new Atom("Te",52, 127.6,10,22,20,0);
        atoms[i++] = new Atom("I",53,126.90,10,23,20,0);
        atoms[i++] = new Atom("Xe",54,131.29,10,24,20,0);
        atoms[i++] = new Atom("Cs",55, 132.91,11,24,20,0);
        atoms[i++] = new Atom("Ba",56, 137.33,12,24,20,0);
        atoms[i++] = new Atom("La",57,138.91,12,24,21,0);
        atoms[i++] = new Atom("Ce",58,140.12,12,24,21,1);
        atoms[i++] = new Atom("Pr",59,140.91,12,24,20,3);
        atoms[i++] = new Atom("Nd",60, 144.24,12,24,20,4);
    }
    //Tests authenticity
    public boolean testAtom(int index){
        return atoms[index].getNo() == index+1;
    }
    //Return S orbital


}
