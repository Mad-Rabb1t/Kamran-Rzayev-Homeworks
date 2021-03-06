package hw09.Service;

import hw09.Dao.CollectionFamilyDao;
import hw09.Dao.DAO;
import hw09.Entities.*;

import java.util.ArrayList;

public class FamilyService {
    DAO<Family> dao = new CollectionFamilyDao();

    public ArrayList<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        System.out.println(dao.getAllFamilies());
    }

    public ArrayList<Family> getFamiliesBiggerThan(int size) {
        ArrayList<Family> biggers = new ArrayList<>();
        for (Family fam : dao.getAllFamilies()) {
            if (fam.countFamily() > size) {
                biggers.add(fam);
            }
        }
        return biggers;
    }

    public ArrayList<Family> getFamiliesLessThan(int size) {
        ArrayList<Family> smallers = new ArrayList<>();
        for (Family fam : dao.getAllFamilies()) {
            if (fam.countFamily() < size) {
                smallers.add(fam);
            }
        }
        return smallers;
    }

    public int countFamiliesWithMemberNumber(int size) {
        int equals = 0;
        for (Family fam : dao.getAllFamilies()) {
            if (fam.countFamily() == size) {
                equals++;
            }
        }
        return equals;
    }

    public void createNewFamily(Human dad, Human mom) {
        Family fam = new Family(dad, mom);
        dad.setFamily(fam);
        mom.setFamily(fam);
        dao.saveFamily(fam);
    }

    public boolean deleteFamilyByIndex(int index) {
        return dao.deleteFamily(index);
    }

    public Family bornChild(Family fam, String boy_name, String girl_name) {

        int chance = (int) (Math.random()+1);
        switch (chance) {
            case (0): {
                fam.addChild(new Woman(girl_name, fam.getFather().getSurname(), fam));
                break;
            }

            case (1): {
                fam.addChild(new Man(boy_name, fam.getFather().getSurname(), fam));
                break;
            }
        }

        dao.saveFamily(fam);
        return fam;
    }

    public Family adoptChild(Family fam, Human cld) {
        cld.setFamily(fam);
        fam.addChild(cld);
        dao.saveFamily(fam);
        return fam;
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family fam : dao.getAllFamilies()) {
            for (int i = 0; i < fam.getChildren().size(); i++) {
                if (2020 - fam.getChildren().get(i).getB_year() > age) fam.deleteChild(i);
            }
            dao.saveFamily(fam);
        }
    }

    public int count() {
        return dao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return dao.getFamilyByIndex(index);
    }

    public ArrayList<Pet> getPets(int index) {
        return new ArrayList<>(dao.getFamilyByIndex(index).getPet());
    }

    public void addPet(int index, Pet pet) {
        Family fam = dao.getFamilyByIndex(index);
        fam.setPet(pet);
        dao.saveFamily(fam);
    }
}
