package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    TVRealityList<String> tvRealityListCircular = new TVRealityList<>(5, 0);
    TVRealityList<String> tvRealityListRebote = new TVRealityList<>(5, 1);
    Winner winner = new Winner ();


    public TVRealityList<String> getTvRealityListCircular() {
        return tvRealityListCircular;
    }

    public TVRealityList<String> getTvRealityListRebote() {
        return tvRealityListRebote;
    }

    @Test
    void ConstructoresTest() {
        assertThrows(IllegalArgumentException.class, () -> new TVRealityList<>(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Rebote<>(new ArrayList<>(), -1));
        assertThrows(IllegalArgumentException.class, () -> new Circular<>(new ArrayList<>(), -1));
    }
    @Test
    void addName() {
        getTvRealityListCircular().addName("Pedro");
        assertEquals(getTvRealityListCircular().getByIndex(0), "Pedro");
        getTvRealityListCircular().addName("Maria");
        assertEquals(getTvRealityListCircular().getByIndex(1), "Maria");
        getTvRealityListCircular().addName("Juan");
        assertEquals(getTvRealityListCircular().getByIndex(2), "Juan");
        getTvRealityListCircular().addName("Luis");
        assertEquals(getTvRealityListCircular().getByIndex(3), "Luis");
        getTvRealityListCircular().addName("Teresa");
        assertEquals(getTvRealityListCircular().getByIndex(4), "Teresa");
        assertThrows(UnsupportedOperationException.class, () -> getTvRealityListCircular().addName("Andrea"));
    }
    //Circular
    @Test
    void selectCandidateCircular1() {
        getTvRealityListCircular().addName("Juan");
        getTvRealityListCircular().addName("Alberto");
        getTvRealityListCircular().addName("Guille");
        getTvRealityListCircular().addName("Andres");
        getTvRealityListCircular().addName("Marcos");
        assertEquals(winner.selectCandidates(getTvRealityListCircular(),true,1),"Marcos");
    }
    @Test
    void selectCandidateCircular2() {
        getTvRealityListCircular().addName("Juan");
        getTvRealityListCircular().addName("Alberto");
        getTvRealityListCircular().addName("Guille");
        getTvRealityListCircular().addName("Andres");
        getTvRealityListCircular().addName("Marcos");
        assertEquals(winner.selectCandidates(getTvRealityListCircular(),true,2),"Guille");
    }
    @Test
    void selectCandidateCircular3() {
        getTvRealityListCircular().addName("Juan");
        getTvRealityListCircular().addName("Alberto");
        getTvRealityListCircular().addName("Guille");
        getTvRealityListCircular().addName("Andres");
        getTvRealityListCircular().addName("Marcos");
        assertEquals(winner.selectCandidates(getTvRealityListCircular(),true,3),"Andres");
    }
    @Test
    void selectCandidateCircular4() {
        getTvRealityListCircular().addName("Juan");
        getTvRealityListCircular().addName("Alberto");
        getTvRealityListCircular().addName("Guille");
        getTvRealityListCircular().addName("Andres");
        getTvRealityListCircular().addName("Marcos");
        assertEquals(winner.selectCandidates(getTvRealityListCircular(),true,4),"Juan");
    }
    @Test
    void selectCandidateCircular5() {
        getTvRealityListCircular().addName("Juan");
        getTvRealityListCircular().addName("Alberto");
        getTvRealityListCircular().addName("Guille");
        getTvRealityListCircular().addName("Andres");
        getTvRealityListCircular().addName("Marcos");
        assertEquals(winner.selectCandidates(getTvRealityListCircular(),true,5),"Alberto");
    }
    //Rebote
    @Test
    void selectCandidateRebote1(){
        getTvRealityListRebote().addName("Maria");
        getTvRealityListRebote().addName("Ana");
        getTvRealityListRebote().addName("Cristina");
        getTvRealityListRebote().addName("Lucia");
        getTvRealityListRebote().addName("Laura");
        assertEquals(winner.selectCandidates(getTvRealityListRebote(),true,1),"Laura");
    }
    @Test
    void selectCandidateRebote2(){
        getTvRealityListRebote().addName("Maria");
        getTvRealityListRebote().addName("Ana");
        getTvRealityListRebote().addName("Cristina");
        getTvRealityListRebote().addName("Lucia");
        getTvRealityListRebote().addName("Laura");
        assertEquals(winner.selectCandidates(getTvRealityListRebote(),true,2),"Maria");
    }
    @Test
    void selectCandidateRebote3(){
        getTvRealityListRebote().addName("Maria");
        getTvRealityListRebote().addName("Ana");
        getTvRealityListRebote().addName("Cristina");
        getTvRealityListRebote().addName("Lucia");
        getTvRealityListRebote().addName("Laura");
        assertEquals(winner.selectCandidates(getTvRealityListRebote(),true,3),"Maria");
    }
    @Test
    void selectCandidateRebote4(){
        getTvRealityListRebote().addName("Maria");
        getTvRealityListRebote().addName("Ana");
        getTvRealityListRebote().addName("Cristina");
        getTvRealityListRebote().addName("Lucia");
        getTvRealityListRebote().addName("Laura");
        assertEquals(winner.selectCandidates(getTvRealityListRebote(),true,4),"Ana");
    }
    @Test
    void selectCandidateRebote5(){
        getTvRealityListRebote().addName("Maria");
        getTvRealityListRebote().addName("Ana");
        getTvRealityListRebote().addName("Cristina");
        getTvRealityListRebote().addName("Lucia");
        getTvRealityListRebote().addName("Laura");
        assertEquals(winner.selectCandidates(getTvRealityListRebote(),true,5),"Maria");
    }
}