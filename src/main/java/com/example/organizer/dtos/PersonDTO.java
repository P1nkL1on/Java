package com.example.organizer.dtos;


public class PersonDTO {
    private long id;
    private String name;
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setArgs (long id, Integer age, String name){
        setName(name);
        setAge(age);
        setId(id);
    }

    @Override
    public String toString() {
        return "Person (DTO):" + "    ID\t" + id + "    NAME\t'" + name + '\'' + "    AGE\t" + age + '\n';
    }
}
