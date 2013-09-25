package exam.one;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午9:53
 * To change this template use File | Settings | File Templates.
 */
public interface IFruit {
    Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public Double getUnitPrice();

    public void setUnitPrice(Double unitPrice);

    public Double getInventory();

    public void setInventory(Double inventory);
}
