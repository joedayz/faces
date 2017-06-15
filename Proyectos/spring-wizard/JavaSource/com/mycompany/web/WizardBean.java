package com.mycompany.web;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.hibernate.validator.Email;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Pattern;

import com.mycompany.service.OrderService;
import com.mycompany.utils.JSFUtils;

public class WizardBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Name must not be empty")
    @Pattern(regex = ".*[^\\s].*", message = "This string contain only spaces")
    private String name;

    @NotEmpty
    @Email(message = "Invalid email format")
    private String email;

    private String drink;
    private String comments;
    private String drinkCategorySelected;
   
    private OrderService orderService;

    private String startPage;
   
    private List<SelectItem> drinkCategory;
    private List<SelectItem> drinkList;

    // init all drinks
    private static final String [] CATEGORY = {"Brandy", "Rum", "Tequila", "Whiskey", "Wine", "Beer"};
    private static final String [] BRANDY = {"XO", "VSOP", "VS"};
    private static final String [] RUM = {"Medium", "Full-bodied", "Aromatic"};
    private static final String [] TEQUILA = {"Reposado", "A–ejo", "Blanco"};
    private static final String [] WHISKEY = {"Malt", "Grain", "Single Malt", };
    private static final String [] WINE = {"Red", "White", "Pink"};
    private static final String [] BEER = {"Ales", "Lager", "Specialty Beer", };
   
    public void changeDrink(ValueChangeEvent event) {
        String newValue = (String) event.getNewValue();
       
        if (newValue.equals("Brandy")) {setDrinkList(JSFUtils.createList(BRANDY)); drink=BRANDY[0];}
        else if (newValue.equals("Rum")) {setDrinkList(JSFUtils.createList(RUM)); drink=RUM[0];}
        else if (newValue.equals("Tequila")) {setDrinkList(JSFUtils.createList(TEQUILA));drink=TEQUILA[0];}
        else if (newValue.equals("Whiskey")) {setDrinkList(JSFUtils.createList(WHISKEY));drink=WHISKEY[0];}
        else if (newValue.equals("Wine")) {setDrinkList(JSFUtils.createList(WINE));drink=WINE[0];}
        else if (newValue.equals("Beer")) {setDrinkList(JSFUtils.createList(BEER));drink=BEER[0];}
    }
   
    @PostConstruct
    public void create() {
        drinkCategorySelected = CATEGORY[0];
        setDrinkCategory(JSFUtils.createList(CATEGORY));
        setDrinkList(JSFUtils.createList(BRANDY));
        drink = BRANDY[0];
    }
    public void save() {
        orderService.addOrder(name, email, drink, comments);
        this.setStartPage("/page1.xhtml");

        FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
                .remove("wizardBean");
    }

    //getters y setters
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String getStartPage() {
		return startPage;
	}

	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	public String getDrinkCategorySelected() {
		return drinkCategorySelected;
	}

	public void setDrinkCategorySelected(String drinkCategorySelected) {
		this.drinkCategorySelected = drinkCategorySelected;
	}

	public List<SelectItem> getDrinkCategory() {
		return drinkCategory;
	}

	public void setDrinkCategory(List<SelectItem> drinkCategory) {
		this.drinkCategory = drinkCategory;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public List<SelectItem> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(List<SelectItem> drinkList) {
		this.drinkList = drinkList;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




	
} 