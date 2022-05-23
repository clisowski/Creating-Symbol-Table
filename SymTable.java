
import java.util.*;

//Class SymTable
public class SymTable {

        // list to store identifiers
        private List<HashMap<String, Sym>> list;

        /*
         * Constructor, it initialize the SymTable's List field to contain a single,
         * empty HashMap
         */
        public SymTable() {

                list = new LinkedList<>(); // initializing list
                list.add(new HashMap<>()); // adding empty hashMap

        }

        /**
         * If this SymTable's list is empty, throw an EmptySymTableException. If either name or sym (or both) is null, throw an IllegalArgumentException.
         * If the first HashMap in the list already contains the given name as a key, throw a DuplicateSymException. Otherwise, add the given name and 
         * sym to the first HashMap in the list.
         * @param name
         * @param sym
         * @throws DuplicateSymException
         * @throws EmptySymTableException
         */
        
        public void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {
                // throw exception when list is empty
                if (list.isEmpty()) {
                        throw new EmptySymTableException();
                }
                // throw exception if parameters are null
                if (name == null || sym == null) {
                        throw new IllegalArgumentException();
                }
                // throw exception if map already contains the key
                if (list.get(0).containsKey(name)) {
                        throw new DuplicateSymException();
                }
                // adding an entry to first hashMap in list
                list.get(0).put(name, sym);
        }

        /**
         * Add a new, empty HashMap to the front of the list.
         */
        public void addScope() {
                list.add(0, new HashMap<>());
        }

        /**
         * If this SymTable's list is empty, throw an EmptySymTableException. Otherwise, if the first HashMap 
         * in the list contains name as a key, return the associated Sym; otherwise, return null.
         * @param name
         * @return return first HashMap in the list if it contains the corresponding key, otherwise null
         * @throws EmptySymTableException
         */
        public Sym lookupLocal(String name) throws EmptySymTableException {
                // throw exception when list is empty
                if (list.isEmpty()) {
                        throw new EmptySymTableException();
                }
                // returning Sym if hashMap contains key
                if (list.get(0).containsKey(name)) {
                        return list.get(0).get(name);
                }

                return null;

        }

        /**
         * If this SymTable's list is empty, throw an EmptySymTableException. Otherwise, if any HashMap in the list contains name as a key,
         *  return the first associated Sym (i.e., the one from the HashMap that is closest to the front of the list); otherwise, return null.
         * @param name
         * @return first associated Sym to corresponding key, otherwise return null
         * @throws EmptySymTableException
         */
        public Sym lookupGlobal(String name) throws EmptySymTableException {
                // throw exception when list is empty
                if (list.isEmpty()) {
                        throw new EmptySymTableException();
                }
                // iterating over the list using advanced for loop
                for (HashMap<String, Sym> map : list) {
                        // checking whether the map contains the given key
                        if (map.containsKey(name)) {
                                // returning Sym with matching key
                                return map.get(name);
                        }
                }

                return null;
        }

        /**
         * If this SymTable's list is empty, throw an EmptySymTableException; otherwise, remove the HashMap from the front of the list. To 
         * clarify, throw an exception only if before attempting to remove, the list is empty (i.e., there are no HashMaps to remove).
         * @throws EmptySymTableException
         */
        public void removeScope() throws EmptySymTableException {
                // throw exception if list is empty
                if (list.isEmpty()) {
                        throw new EmptySymTableException();
                }
                // removing first hashMap from list
                list.remove(0);
        }

        /**
         * This method is for debugging. First, print "\n** Sym Table **\n". Then, for each HashMap M in the list, print M.toString() followed by a
         * newline. Finally, print one more newline. All output should go to System.out.
         */
        public void print() {
                System.out.print("\n** Sym Table **\n");
                // iterating over the list and printing hashMap
                for (HashMap<String, Sym> m : list) {
                        System.out.print(m.toString() + "\n");
                }
                
                System.out.print("\n");
        }

}
