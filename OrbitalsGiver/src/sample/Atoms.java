package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Atoms {

    private ArrayList<Atom> atoms = new ArrayList<>();
    private int pointer = 0;

    //Takes from list given by Trine
    public Atoms() {
        initAtomList("/home/snooze/Git/Scooby/OrbitalsGiver/src/Orbitals.txt");
    }
    //Different way to initAtom from list
    private void initAtomList(String filepath){
        Scanner text;
        try {
            text = new Scanner(new File(filepath));
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        System.out.println("File found!");

        sortAtoms(text);
    }
    //Sorts the atoms from list by Trine. Makes list with following values:
    //Symbole.name, atomic number, orbitals as a string, the number og electrons in orbitals
    //S, P, D, F
    public void sortAtoms(Scanner text){
        String name;
        String orbitals;
        int S, P, D, F, no;
        while(text.hasNextLine()){
            name = text.next();
            no = Integer.parseInt(text.next());
            S = Integer.parseInt(text.next());
            P = Integer.parseInt(text.next());
            D = Integer.parseInt(text.next());
            F = Integer.parseInt(text.next());
            orbitals = text.nextLine();

            atoms.add(new Atom(name,no,S,P,D,F,orbitals));
            pointer++;
        }


        System.out.println(atoms.get(0));



    }

    //Return S orbital
    private void printAtoms(){
        for(int i = 0; i < pointer; i++){
            System.out.println(atoms.get(i));
        }
    }

    public Atom getAtom(String atomSymbol){
        Atom testAtom = new Atom(atomSymbol);
        if(atoms.contains(testAtom)){
            for(int i = 0; i < pointer; i++){
                if(atoms.get(i).getSymbol().equals(atomSymbol)){
                    return atoms.get(i);
                }
            }
        }
        return new Atom("");

    }

}
