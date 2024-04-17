package familytree;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private String name;
    private LocalDate dob;
    private Gender gender;
    private Human mother;
    private Human father;

    public Human(String name, LocalDate dob, Gender gender, Human mother, Human father) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, Gender gender, LocalDate dob) {
        this(name, dob, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Человек{")
                .append("Имя='").append(name).append('\'')
                .append(", Дата рождения=").append(dob)
                .append(", Пол=").append(gender == Gender.Male ? "Мужской" : "Женский");
        if (mother != null) {
            builder.append(", Мать=").append(mother.getName());
        } else {
            builder.append(", Мать=Неизвестно");
        }
        if (father != null) {
            builder.append(", Отец=").append(father.getName());
        } else {
            builder.append(", Отец=Неизвестно");
        }
        return builder.append('}').toString();
    }
}