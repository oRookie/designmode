package immutable;

class UsePerson extends Thread {
    private Person person;
    public UsePerson(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " print "+person.getName() + " : "+person.getAddress());
    }
}
