package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinesweeperCellTest {

    @Test
    public void isBlockedTest() {
        MinesweeperCell cell = new MinesweeperCell();
        cell.block();
        assertTrue(cell.isBlocked());
    }

    @Test
    public void notBlockedTest() {
        MinesweeperCell cell = new MinesweeperCell();
        assertFalse(cell.isBlocked());
    }
    
    @Test
    public void isBlockedTestWithNotBlockedCell() {
        MinesweeperCell cell = new MinesweeperCell();
        // In this step, the cell is not blocked
        
        assertFalse(cell.isBlocked());
    }
    
    @Test
    public void isBlockedTestWithBlockedCell() {
        MinesweeperCell cell = new MinesweeperCell();
        // In this step, the cell is not blocked
        
        cell.block();
        // In this step, the cell is blocked
        
        assertTrue(cell.isBlocked());
    }

    @Test
    public void hasMineFalse(){
        MinesweeperCell cell = new MinesweeperCell();
        assertFalse(cell.hasMine());
    }

    @Test
    public void hasMineTrue() {
        MinesweeperCell cell = new MinesweeperCell();
        cell.putMine();
        assertTrue(cell.hasMine());
    }

    @Test
    public void isOpen() {
        MinesweeperCell cell = new MinesweeperCell();
        cell.open();
        assertTrue(cell.isOpen());
    }
    
    @Test
    public void isNotOpen() {
        MinesweeperCell cell = new MinesweeperCell();
        assertFalse(cell.isOpen());
    }

    @Test
    public void isClose(){
        MinesweeperCell cell = new MinesweeperCell();
        assertTrue(cell.isClose());
    }

    @Test
    public void putMineTest(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.putMine();
        assertTrue(cell.hasMine());
    }
    
    @Test
    public void notPutMineWhenHaveMineTest(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.putMine();
        cell.putMine();
        assertTrue(cell.hasMine());
    }
    
    @Test(expected=IllegalStateException.class)
    public void notPutMineTest(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.open();
        assertFalse(cell.hasMine());
    }
    
    @Test(expected=IllegalStateException.class)
    public void notPutMineWhenIsOpenTest(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.open();
        cell.putMine();
    }
    
    @Test(expected=IllegalStateException.class)
    public void notPutMineWhenIsCloseTest(){
        MinesweeperCell cell = new MinesweeperCell();        
        assertFalse(cell.hasMine());
    }
    
    @Test
    public void blockAClosedCell(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.block();
        assertTrue(cell.isBlocked());
    }

    @Test(expected=IllegalStateException.class)
    public void blockAOpenCell(){
        MinesweeperCell cell = new MinesweeperCell();
        cell.open();
        cell.block();
        assertFalse(cell.isBlocked());
    }
    
    @Test(expected = IllegalStateException.class)
    public void unblockAnUnblockedCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.unblock();
    }

    @Test
    public void unblockABlockedCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.block();
    	cell.unblock();
    	assertFalse(cell.isBlocked());
    }

    @Test(expected = IllegalStateException.class)
    public void unblockAnOpenCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.open();
    	cell.unblock();
    }

    @Test
    public void unblockACellWithMines(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.putMine();
    	cell.block();
    	cell.unblock();
    	assertFalse(cell.isBlocked());
    }
    
    @Test (expected = IllegalStateException.class)
    public void openAnOpenedCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.open();
    	cell.open();
    }

    @Test 
    public void openAClosedCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.open();
    	assertTrue(cell.isOpen());
    }
    
    @Test
    public void openACellWithMines(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.putMine();
    	cell.open();
    	assertTrue(cell.isOpen());
    }
    
    @Test (expected = IllegalStateException.class)
    public void openABlockedCell(){
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.block();
    	cell.open();
    }

    @Test
    public void closedCellTest(){
    	MinesweeperCell cell = new MinesweeperCell();
    	assertTrue(cell.isClose());
    }

    @Test
    public void notClosedCellTest(){
    	// the name of the test is the negation of closedCellTest
    	// because check the method isClose
    	MinesweeperCell cell = new MinesweeperCell();
    	cell.open();
    	assertFalse(cell.isClose());
    }

}
