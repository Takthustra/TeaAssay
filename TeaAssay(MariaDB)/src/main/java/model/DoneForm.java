package model;

import dao.FormDAO;

public class DoneForm {
	public void execute(Form form) {
		FormDAO dao = new FormDAO();
		dao.insert(form);
	}

}
