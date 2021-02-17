    public class HelloWorld {
        private String name;

        public void setName(final String name) {
            this.name = name;
        }

        public void printHello() {
            System.out.println("Spring Framework: Hello, " + name + "!");
        }
    }
