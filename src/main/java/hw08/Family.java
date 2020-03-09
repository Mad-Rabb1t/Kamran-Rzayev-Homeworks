package hw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private Integer cld_index = 0;
    protected HashSet<Pet> pets;

    public Family(Human father, Human mother, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.pets.add(pet);
        father.setFamily(this);
        mother.setFamily(this);
    }

//    public Human getFather() {
//        return father;
//    }

//    public void setFather(Human father) {
//        this.father = father;
//    }

//    public Human getMother() {
//        return mother;
//    }

//    public void setMother(Human mother) {
//        this.mother = mother;
//    }

    public HashSet<Pet> getPet() {
        return pets;
    }

    public void setPet(Pet pet) {
        this.pets.add(pet);
    }

//    public Human[] getChildren() {
//        return children;
//    }
//
//    public void setChildren(Human[] children) {
//        this.children = children;
//    }


    public void describePet() {
        for (Pet pet: pets){
            System.out.printf("I have a %s, he is %d years old, he is ", pet.getSpecies(), pet.getAge());
            if (pet.getTrickLevel() < 50) System.out.println("almost not sly.");
            else System.out.println("very sly");
        }

    }

    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deleteChild(int index) {
        try {
            children.remove(index);
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    public boolean deleteChild(Human child) {
        try {
            children.remove(child);
        } catch (Exception ex) {
            System.out.println("Error occurred");
        }
        System.out.println("Unable to delete the child...");
        return false;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, children.toString(), pets.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family has been deleted...");
        super.finalize();
    }
}