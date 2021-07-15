import java.util.*;

public class Contact implements Iterable<Contact> {
	private ArrayList<Contact> contacts;
	/* 
	
	
	I MADE CHANGES
	
	
	*/
	

	public Contact() {
		contacts = new ArrayList<>();
	}
	/* 
	
	
	I MADE more CHANGES
	
	
	*/

	public Contact(Contact[] contacts) {
		this.contacts = new ArrayList<>(Arrays.asList(contacts));
	}
	/* 
	
	
	CHANGES
	
	
	*/

	Contact findByLastName(String last) {
		int left = 0;
		int right = contacts.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (this.contacts.get(mid).getLastName().equals(last)) {

				return contacts.get(mid);
			}

			if (this.contacts.get(mid).getLastName().compareTo(last) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return null;
	}

	Contact findByPhoneNumber(String phone) {
		Contact list = new Contact();

		for (Contact contactInList : contacts) {
			if (contactInList.getPhoneNum().equals(phone)) {
				list.add(contactInList);
				return contactInList;
			}
		}

		return null;
	}

	Contact findAllByLastInitial(char ch) {
		Contact list = new Contact();

		for (Contact contactInList : contacts) {
			if (contactInList.getLastName().charAt(0) == ch) {
				list.add(contactInList);
				return list;
			}
		}

		return null;
	}
	//Find contacts by City
	Contact findAllByCity(String city) {
		Contact list = new Contact();

		for (Contact contactInList : contacts) {
			if (contactInList.getCity().equals(city)) {
				list.add(contactInList);
				return list;
			}
		}

		return null;
	}
	//I couldn't figure out how to return with boolean so I made a void method
	public void add(Contact c) {
	//	Collections.sort(contacts);
		int index = Collections.binarySearch(contacts, c);
		
		if(index<0) { 
			contacts.add(c);
		}
		
		Collections.sort(contacts);
		

	}
	
	int size() {
		return contacts.size();
	}

	Contact get(int index) {
		if(index>=contacts.size() || index <0) {

			throw new IndexOutOfBoundsException("Index " + index + " was not fount!");
		}
		return contacts.get(index);
		
	}
	
	Contact remove(Contact obj) {
		Contact n = new Contact();
		
		for(int i =0; i<contacts.size();i++) {
			if(contacts.get(i).equals(obj)) {
				n.add(obj);
				return contacts.remove(i);
			}
		}
		return null;
				
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		return true;
	}

	@Override
	public Iterator<Contact> iterator() {
		// TODO Auto-generated method stub
		return contacts.iterator();
	}

	@Override
	public String toString() {
		return ""+  contacts;
	}

}
