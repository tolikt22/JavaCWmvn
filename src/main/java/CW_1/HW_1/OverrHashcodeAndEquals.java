package CW_1.HW_1;

class OverrHashcodeAndEquals {
    public static void main(String[] args) {
        BlackBox object1 = new BlackBox(5, 10);
        BlackBox object2 = new BlackBox(5, 10);
//            String object1 = new String("fwefwef");
//            String object2 = new String("fwefwef");
        System.out.println(object1.equals(object2));
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
        System.out.println(51&15);

    }
    static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static class BlackBox {
        int varA;
        int varB;

        BlackBox(int varA, int varB) {
            this.varA = varA;
            this.varB = varB;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = result * prime + varA;
            result = result * prime + varB;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            BlackBox other = (BlackBox) obj;
            if (varA != other.varA)
                return false;
            if (varB != other.varB)
                return false;
            return true;
        }
    }
}