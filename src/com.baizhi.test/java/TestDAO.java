import com.baizhi.dao.CarouselDAO;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
public class TestDAO {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        MenuDAO menuDAO = (MenuDAO) ac.getBean("menuDAO");
        List<Menu> list = menuDAO.queryAll();
        for (Menu menu:list){
            System.out.println(menu);
        }
    }

    @Test
    public void testCarouselInsert(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        CarouselDAO carouselDAO= (CarouselDAO) ac.getBean("carouselDAO");
        carouselDAO.insert(new Carousel(1,"轮播图1","/img/shouye/1.jpg","图片描述",1,new Date()));

    }

    @Test
    public void textCarouselDelete(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        CarouselDAO carouselDAO= (CarouselDAO) ac.getBean("carouselDAO");
        carouselDAO.delete(1);

    }

    @Test
    public void testCarouselUpdate(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        CarouselDAO carouselDAO= (CarouselDAO) ac.getBean("carouselDAO");
        carouselDAO.update(new Carousel(1,"轮播图1","/img/shouye/1.jpg","图片描述",2,new Date()));
    }

    @Test
    public void testCarouselCount(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("sping.xml");
        CarouselDAO carouselDAO= (CarouselDAO) ac.getBean("carouselDAO");
        System.out.println(carouselDAO.count());
    }




}
