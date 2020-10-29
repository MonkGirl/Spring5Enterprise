package pattern;

import com.monkgirl.spring5.pattern.abstractfactory.ComputerFactory;
import com.monkgirl.spring5.pattern.abstractfactory.FactoryProducer;
import com.monkgirl.spring5.pattern.abstractfactory.PriceFactory;
import com.monkgirl.spring5.pattern.abstractfactory.impl.Rmb;
import com.monkgirl.spring5.pattern.adapter.impl.AudioPlayer;
import com.monkgirl.spring5.pattern.bridge.ComputerBridge;
import com.monkgirl.spring5.pattern.builder.Computer;
import com.monkgirl.spring5.pattern.builder.ComputerBuilder;
import com.monkgirl.spring5.pattern.chainofresponsibility.DirtyFilter;
import com.monkgirl.spring5.pattern.chainofresponsibility.PrivacyFilter;
import com.monkgirl.spring5.pattern.chainofresponsibility.SensitiveFilter;
import com.monkgirl.spring5.pattern.command.AttentionCommand;
import com.monkgirl.spring5.pattern.command.Broker;
import com.monkgirl.spring5.pattern.command.Soldier;
import com.monkgirl.spring5.pattern.command.StandAtEaseCommand;
import com.monkgirl.spring5.pattern.composite.Staff;
import com.monkgirl.spring5.pattern.criteria.Criteria;
import com.monkgirl.spring5.pattern.criteria.Person;
import com.monkgirl.spring5.pattern.criteria.impl.*;
import com.monkgirl.spring5.pattern.decorator.GoldenComputerDecorator;
import com.monkgirl.spring5.pattern.decorator.RedComputerDecorator;
import com.monkgirl.spring5.pattern.decorator.WhiteComputerDecorator;
import com.monkgirl.spring5.pattern.facade.ComputerFacade;
import com.monkgirl.spring5.pattern.flyweight.ComputerSuperFactory;
import com.monkgirl.spring5.pattern.interceptingfilter.Client;
import com.monkgirl.spring5.pattern.interceptingfilter.FilterManager;
import com.monkgirl.spring5.pattern.interceptingfilter.Target;
import com.monkgirl.spring5.pattern.interpreter.AndExpression;
import com.monkgirl.spring5.pattern.interpreter.Expression;
import com.monkgirl.spring5.pattern.interpreter.NumericalExpression;
import com.monkgirl.spring5.pattern.interpreter.OrExpression;
import com.monkgirl.spring5.pattern.iterator.IntegerRepository;
import com.monkgirl.spring5.pattern.iterator.Iterator;
import com.monkgirl.spring5.pattern.mediator.User;
import com.monkgirl.spring5.pattern.memento.Original;
import com.monkgirl.spring5.pattern.memento.StateKeeper;
import com.monkgirl.spring5.pattern.nullobject.AbstractObject;
import com.monkgirl.spring5.pattern.nullobject.ObjectFactory;
import com.monkgirl.spring5.pattern.observer.Observer;
import com.monkgirl.spring5.pattern.observer.WeChatPublic;
import com.monkgirl.spring5.pattern.observer.WeChatUser;
import com.monkgirl.spring5.pattern.prototype.ComputerPrototype;
import com.monkgirl.spring5.pattern.prototype.impl.Asus;
import com.monkgirl.spring5.pattern.prototype.impl.Lenovo;
import com.monkgirl.spring5.pattern.prototype.impl.Macbook;
import com.monkgirl.spring5.pattern.proxy.Magnate;
import com.monkgirl.spring5.pattern.proxy.MagnateProxy;
import com.monkgirl.spring5.pattern.state.Rain;
import com.monkgirl.spring5.pattern.state.Sunshine;
import com.monkgirl.spring5.pattern.state.Weather;
import com.monkgirl.spring5.pattern.strategy.Addition;
import com.monkgirl.spring5.pattern.strategy.Context;
import com.monkgirl.spring5.pattern.strategy.Multiplication;
import com.monkgirl.spring5.pattern.strategy.Subtraction;
import com.monkgirl.spring5.pattern.template.Game;
import com.monkgirl.spring5.pattern.template.SuperMarie;
import com.monkgirl.spring5.pattern.template.Tetris;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 08:55
 * @description
 */
class TestPattern {

    @Test
    void testPrototype() {
        Asus asus = (Asus) ComputerPrototype.getComputer("asus");
        assertNotNull(asus, "asus is null");
        asus.make();
        System.out.println(asus.getId());
        Asus asus1 = (Asus) ComputerPrototype.getComputer("asus");
        assertNotNull(asus1, "asus is null");
        System.out.println(asus1.getId());

        Asus a1 = new Asus();
        Asus a2 = new Asus();
        System.out.println(a1.getId());
        System.out.println(a2.getId());
    }

    @Test
    void testFactory() {
        ComputerFactory factory = new ComputerFactory();
        Asus asus = (Asus) factory.createComputer("asus");
        assertNotNull(asus);
        asus.make();
        Lenovo lenovo = (Lenovo) factory.createComputer("lenovo");
        assertNotNull(lenovo);
        lenovo.make();
        Macbook macbook = (Macbook) factory.createComputer("macbook");
        assertNotNull(macbook);
        macbook.make();
    }

    @Test
    void testAbstractFactory() {
        ComputerFactory computerFactory = (ComputerFactory) FactoryProducer.getFactory("computer");
        assertNotNull(computerFactory, "computerFactory is null");
        Lenovo lenovo = (Lenovo) computerFactory.createComputer("lenovo");
        lenovo.make();

        PriceFactory priceFactory = (PriceFactory) FactoryProducer.getFactory("price");
        assertNotNull(priceFactory, "priceFactory is null");
        Rmb rmb = (Rmb) priceFactory.createPrice("rmb");
        rmb.setPrice();
    }

    @Test
    void testAdapter() {
        AudioPlayer player = new AudioPlayer();
        assertNotNull(player);
        player.play("mp3");
        player.play("mp4");
        player.play("rmvb");
    }

    @Test
    void testBridge() {
        ComputerBridge asus = new ComputerBridge(new Asus());
        assertNotNull(asus);
        asus.makeComputer();
        ComputerBridge lenovo = new ComputerBridge(new Lenovo());
        assertNotNull(lenovo);
        lenovo.makeComputer();
        ComputerBridge macbook = new ComputerBridge(new Macbook());
        assertNotNull(macbook);
        macbook.makeComputer();
    }

    @Test
    void testBuilderFactory() {
        ComputerBuilder computerBuilder = new ComputerBuilder();
        Computer cheapComputer = computerBuilder.buildCheap();
        assertNotNull(cheapComputer);
        cheapComputer.showItem();

        Computer expensiveComputer = computerBuilder.buildExpensive();
        assertNotNull(expensiveComputer);
        expensiveComputer.showItem();
    }

    @Test
    void testCriteria() {
        Person person1 = new Person("Icarus", "male", "single");
        Person person2 = new Person("Aurora", "female", "married");
        Person person3 = new Person("Zeus", "male", "married");
        Person person4 = new Person("Cynthia", "female", "married");
        Person person5 = new Person("Lee", "female", "single");
        Person person6 = new Person("Young", "male", "single");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        Criteria criteriaMale = new CriteriaMale();
        assertNotNull(criteriaMale);
        System.out.println(criteriaMale.meetCriteria(personList));

        Criteria criteriaFemale = new CriteriaFemale();
        System.out.println(criteriaFemale.meetCriteria(personList));

        Criteria criteriaSingle = new CriteriaSingle();
        System.out.println(criteriaSingle.meetCriteria(personList));

        Criteria andCriteria = new AndCriteria(criteriaMale, criteriaSingle);
        System.out.println(andCriteria.meetCriteria(personList));

        Criteria orCriteria = new OrCriteria(criteriaFemale, criteriaSingle);
        System.out.println(orCriteria.meetCriteria(personList));
    }


    @Test
    void testComposite() {
        Staff boss = new Staff(1, "Icarus", "Boss");
        Staff cto = new Staff(2, "Zeus", "IT");
        Staff salesDirector = new Staff(3, "Martin", "Marketing");

        boss.addSubordinateList(cto);
        boss.addSubordinateList(salesDirector);

        Staff engineer1 = new Staff(4, "Tom", "IT");
        Staff engineer2 = new Staff(5, "Jack", "IT");
        cto.addSubordinateList(engineer1);
        cto.addSubordinateList(engineer2);

        Staff salesExecutive1 = new Staff(6, "Rob", "Marketing");
        Staff salesExecutive2 = new Staff(7, "Michael", "Marketing");
        salesDirector.addSubordinateList(salesExecutive1);
        salesDirector.addSubordinateList(salesExecutive2);

        System.out.println(boss);
        assertNotNull(boss.getSubordinateList());
        for (Staff manager : boss.getSubordinateList()) {
            System.out.println(manager);
            assertNotNull(manager.getSubordinateList());
            for (Staff staff : manager.getSubordinateList()) {
                System.out.println(staff);
            }
        }
    }

    @Test
    void testDecorator() {
        com.monkgirl.spring5.pattern.factoy.Computer asus = new GoldenComputerDecorator(new com.monkgirl.spring5.pattern.factoy.impl.Asus());
        assertNotNull(asus);
        asus.make();

        com.monkgirl.spring5.pattern.factoy.Computer lenovo = new RedComputerDecorator(new com.monkgirl.spring5.pattern.factoy.impl.Lenovo());
        assertNotNull(lenovo);
        lenovo.make();

        com.monkgirl.spring5.pattern.factoy.Computer macbook = new WhiteComputerDecorator(new com.monkgirl.spring5.pattern.factoy.impl.Macbook());
        assertNotNull(macbook);
        macbook.make();
    }

    @Test
    void testFacade() {
        ComputerFacade computerFacade = new ComputerFacade();
        assertNotNull(computerFacade);
        computerFacade.makeAsus();
        computerFacade.makeLenovo();
        computerFacade.makeMacbook();
    }

    @Test
    void testFlyweight() {
        com.monkgirl.spring5.pattern.factoy.Computer asus = ComputerSuperFactory.getComputer("asus");
        assertNotNull(asus);
        asus.make();
    }

    @Test
    void testProxy() {
        MagnateProxy proxy = new MagnateProxy(new Magnate());
        assertNotNull(proxy);
        proxy.buy();
    }

    @Test
    void testChainOfResponsibility() {
        String content = "Dirty Word. Time to go home, Sensitive Word, Privacy World !";
        DirtyFilter dirtyFilter = new DirtyFilter();
        assertNotNull(dirtyFilter);
        PrivacyFilter privacyFilter = new PrivacyFilter();
        privacyFilter.setNextAbstractFilter(dirtyFilter);
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        sensitiveFilter.setNextAbstractFilter(privacyFilter);

        System.out.println(sensitiveFilter.filter(content));
    }

    @Test
    void testCommand() {
        Soldier soldier = new Soldier();
        assertNotNull(soldier);
        AttentionCommand attentionCommand = new AttentionCommand(soldier);
        StandAtEaseCommand standAtEaseCommand = new StandAtEaseCommand(soldier);
        Broker broker = new Broker();
        broker.addCommand(attentionCommand);
        broker.addCommand(standAtEaseCommand);

        broker.executeCommand();
    }

    @Test
    void testInterpreter() {
        Expression expression1 = new NumericalExpression(8, 3);
        Expression expression2 = new NumericalExpression(4, 9);
        assertNotNull(expression1);
        assertNotNull(expression2);
        Expression andExpression = new AndExpression(expression1, expression2);
        Expression orExpression = new OrExpression(expression1, expression2);

        System.out.println("8 > 3 && 4 > 9 = " + andExpression.interpreter());
        System.out.println("8 > 3 || 4 > 9 = " + orExpression.interpreter());
    }

    @Test
    void testIterator() {
        Integer[] numbers = {5, 9, 3, 5, 30, -29};
        IntegerRepository integerRepository = new IntegerRepository(numbers);
        assertNotNull(integerRepository);
        Iterator<Integer> iterator = integerRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void testMediator() {
        User tom = new User("Tom");
        User jack = new User("Jack");

        assertNotNull(tom);
        assertNotNull(jack);

        tom.sendMessage("Hello Jack! ");
        jack.sendMessage("Hi Tom !");
    }

    @Test
    void testMemento() {
        Original original = new Original();
        assertNotNull(original);
        StateKeeper stateKeeper = new StateKeeper();
        original.setState("State 1");
        stateKeeper.addState(original.saveMementoState());

        original.setState("State 2");
        stateKeeper.addState(original.saveMementoState());

        original.setState("State 3");
        System.out.println("Current State is " + original.getState());

        original.getMementoState(stateKeeper.get(0));
        System.out.println("Initial State : " + original.getState());

        original.getMementoState(stateKeeper.get(1));
        System.out.println("Second State : " + original.getState());
    }

    @Test
    void testObserver() {
        WeChatPublic weChatPublic = new WeChatPublic();
        assertNotNull(weChatPublic);
        WeChatUser tom = new WeChatUser("Tom");
        WeChatUser jack = new WeChatUser("Jack");
        WeChatUser icarus = new WeChatUser("Icarus");
        WeChatUser aurora = new WeChatUser("Aurora");
        weChatPublic.addObserver(tom);
        weChatPublic.addObserver(jack);
        weChatPublic.addObserver(icarus);
        weChatPublic.addObserver(aurora);

        weChatPublic.setMessage("Time to bed!");
    }

    @Test
    void testState() {
        Weather weather = new Weather();
        assertNotNull(weather);
        weather.setState(new Rain());
        System.out.println(weather.getWeather());
        weather.setState(new Sunshine());
        System.out.println(weather.getWeather());
    }

    @Test
    void testNullObject() {
        AbstractObject sun = ObjectFactory.getObject("sun");
        AbstractObject earth = ObjectFactory.getObject("earth");
        AbstractObject moon = ObjectFactory.getObject("moon");
        AbstractObject mars = ObjectFactory.getObject("mars");
        assertNotNull(sun);
        sun.show();
        earth.show();
        moon.show();
        mars.show();
    }

    @Test
    void testStrategy() {
        Context context = new Context(new Addition());
        assertNotNull(context);
        System.out.println("3 + 4 = " + context.execute(3, 4));

        context.setStrategy(new Subtraction());
        System.out.println("3 - 4 = " + context.execute(3, 4));

        context.setStrategy(new Multiplication());
        System.out.println("3 * 4 = " + context.execute(3, 4));
    }

    @Test
    void testTemplate() {
        Game tetris = new Tetris();
        assertNotNull(tetris);
        tetris.play();
        Game superMarie = new SuperMarie();
        superMarie.play();
    }

    @Test
    void testInterceptingFilter(){
        FilterManager filterManager = new FilterManager(new Target());
        assertNotNull(filterManager);
        filterManager.setFilter(new com.monkgirl.spring5.pattern.interceptingfilter.DirtyFilter());
        filterManager.setFilter(new com.monkgirl.spring5.pattern.interceptingfilter.SensitiveFilter());
        filterManager.setFilter(new com.monkgirl.spring5.pattern.interceptingfilter.PrivateFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest();

    }
}
