package com.foxrider;

/**
 * Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года
 */
public class Main {


    public static void main(String[] args) {
        Book book1 = new Book("Маленький принц", "Черти", 2000, 100, "leather", 150, "Экзюпери");
        Book book5 = new Book("Ведь если звезды зажигают, значит это кому нибудь нужно", "Черти", 1990, 2, "leather", 1500, "Маяковский");
        Book book2 = new Book("Большой принц", "Четыре четверти", 2010, 1000, "paper", 15, "Лошков","Кулешков");
        Book book3 = new Book("Средний принц", "Рандомы", 2016, 50, "leather", 180, "Выбиратель");
        Book book4 = new Book("Рандомный детектив", "Черти", 2010, 300, "paper", 150, "Сидни Шелдон");


        Books b = new Books(book1,book2,book5,book4,book3);
        b.booksAfterYear(2000);

        System.out.println("\n\n\n");
        b.booksByPublishingHause("Черти");

        System.out.println("\n\n\n");
        b.booksByAuthor("Кулешков");

    }
}