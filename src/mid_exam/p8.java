package mid_exam;

class Invoice
{

    String partNumber;
    String partDescription;
    int quantity;
    double pricePerItem;

    // Constructor
    Invoice(String pno,String pdesc,int qty,double price)
    {

        partNumber = pno;
        partDescription = pdesc;

        if(qty < 0)
            quantity = 0;
        else
            quantity = qty;

        if(price < 0)
            pricePerItem = 0.0;
        else
            pricePerItem = price;

    }

    // Setter Methods

    public void setPartNumber(String pno)
    {
        partNumber = pno;
    }

    public void setPartDescription(String pdesc)
    {
        partDescription = pdesc;
    }

    public void setQuantity(int qty)
    {
        if(qty < 0)
            quantity = 0;
        else
            quantity = qty;
    }

    public void setPricePerItem(double price)
    {
        if(price < 0)
            pricePerItem = 0.0;
        else
            pricePerItem = price;
    }

    // Getter Methods

    public String getPartNumber()
    {
        return partNumber;
    }

    public String getPartDescription()
    {
        return partDescription;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPricePerItem()
    {
        return pricePerItem;
    }

    // Calculate invoice amount

    public double getInvoiceAmount()
    {
        return quantity * pricePerItem;
    }

}

public class p8
{
    public static void main(String args[])
    {

        Invoice obj = new Invoice("101","Mouse",5,200);

        System.out.println("Part Number: " + obj.getPartNumber());
        System.out.println("Description: " + obj.getPartDescription());
        System.out.println("Quantity: " + obj.getQuantity());
        System.out.println("Price Per Item: " + obj.getPricePerItem());

        System.out.println("Invoice Amount: " + obj.getInvoiceAmount());

    }
}
