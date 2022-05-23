import java.util.*;
public class Sym {

        // attribute for type
        private String type;

        // Constructor
        public Sym(String type) {
                this.type = type;
        }


		// Getter for type
        public String getType() {
                return this.type;
        }

        // toString method (this method will be changed late when more information is stored in a Sym.)
        public String toString() {
                return this.type;
        }
}

