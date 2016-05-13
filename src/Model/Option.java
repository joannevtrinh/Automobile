package Model;

import java.io.Serializable;

public class Option implements Serializable
{
		private String name;
		private float price;
		
		Option()
		{
			name = "";
			price = 0;
			
		}
		
		Option(String inputname, float inputprice)
		{
			name = inputname;
			price = inputprice;
		}
		
		Option(Option obj)
		{
			name = obj.getName();
			price = obj.getPrice();
		}
		
		protected void setName(String inputname)
		{
			name = inputname;
		}
		
		protected String getName()
		{
			return name;
		}
		
		protected void setPrice(float inputprice)
		{
			price = inputprice;
			
		}
		
		protected float getPrice()
		{
			return price;
		}
		
		protected void printAttributes()
		{
			System.out.println("Option name: " + name);
			System.out.println("Cost:" + price);
			System.out.println(" ");
		}
		
		protected float getTotalPrice()
		{
			float tempprice = this.getPrice();
			return tempprice;
		}
		
}
