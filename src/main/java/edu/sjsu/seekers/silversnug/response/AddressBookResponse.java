package edu.sjsu.seekers.silversnug.response;

import edu.sjsu.seekers.silversnug.model.AddressBook;

import java.util.List;

public class AddressBookResponse extends GenericResponse {

    private static final long serialVersionUID = 3543385351755692064L;
    private List<AddressBook> addressBooks;

    public AddressBookResponse(){

    }

    public AddressBookResponse(List<AddressBook> addressBooks) {
        super();
        this.addressBooks = addressBooks;
    }

    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

    public void setAddressBooks(List<AddressBook> addressBooks) {
        this.addressBooks = addressBooks;
    }

    @Override
    public String toString() {
        return "AddressBookResponse{" +
                "addressBooks=" + addressBooks +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
