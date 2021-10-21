package com.homework.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;
    @Column
    private String fileType;
    @Column
    private  String fileName;
    @Column
    @Lob
    private byte[] fileData;

    public Student() {
    }

    public Student(String firstName,String lastName,Integer age,String fileType,String fileName,byte[] fileData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
    public Student(String firstName,String lastName,Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age) && Objects.equals(fileType, student.fileType) && Objects.equals(fileName, student.fileName) && Arrays.equals(fileData, student.fileData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, firstName, lastName, age, fileType, fileName);
        result = 31 * result + Arrays.hashCode(fileData);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                '}';
    }
}
