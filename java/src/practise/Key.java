package practise;


public class Key {

		String firstname;
		String lastname;
		String number;
		String designation;
		
		Key(String firstname, String lastname, String number, String designation){
			this.firstname = firstname;
			this.lastname = lastname;
			this.number = number;
			this.designation = designation;
		}
		
		@Override 
		public boolean equals(Object o){
			boolean eq = false;
			if (this == o) eq = true;
			else if (!(o instanceof Key)) eq = false;
			else {
				Key k = (Key) o;
				if (this.firstname.equals(k.firstname) && this.lastname.equals(k.lastname) && this.number.equals(k.number) && this.designation.equals(k.designation)){
					eq = true;
				}
			}
			return eq;
		}
		
		@Override
		public int hashCode(){
			int result = 31;
			result = result*37 + firstname.hashCode();
			result = result*37 + lastname.hashCode();
			result = result*37 + number.hashCode();
			result = result*37 + designation.hashCode();
			return result;
		}
		
		public Key lookup(String value, String variable){
			if (variable.equals("firstname")){
				return(value.equals(this.firstname)) ? this : null;
			} 	else if (variable.equals("lastname")){
				return(value.equals(this.lastname)) ? this : null;
			} 	else if (variable.equals("number")){
				return(value.equals(this.number)) ? this : null;
			} 	else if (variable.equals("designation")){
				return(value.equals(this.designation)) ? this : null;
			} 	else {
				return null;
			} 					
		}
		
}
