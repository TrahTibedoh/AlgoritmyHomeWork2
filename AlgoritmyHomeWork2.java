import java.util.Iterator;

public class AlgoritmyHomeWork2 {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(234, "Иванов Иван Иванович", "+71111111111"));
        contactList.addToEnd(new Contact(345, "Петров Петр Петрович", "+72222222222"));
        contactList.addToEnd(new Contact(456, "Сидоров Сидр Сидорович", "+73333333333"));
        contactList.addToEnd(new Contact(678, "Сергеев Сергей Сергеевич", "+74444444444"));
        contactList.addToEnd(new Contact(789, "Данилов Данила Данилович", "+75555555555"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();


        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {
        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    
    public static class SingleLinkList<T> implements Iterable {
        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        
        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {

            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

        
            if (isEmpty()) {
                head = newItem;
                tail = newItem;

            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) { 
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}