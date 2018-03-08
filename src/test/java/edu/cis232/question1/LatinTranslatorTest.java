package edu.cis232.question1;

import org.junit.Test;

import static org.junit.Assert.*;

public class LatinTranslatorTest {

	@Test
	public void testThatSinisterIsLeft(){
		assertEquals("left", LatinTranslator.translate("sinister"));
	}

	@Test
	public void testThatDexterIsRight(){
		assertEquals("right", LatinTranslator.translate("dexter"));
	}

	@Test
	public void testThatMediumIsCenter(){
		assertEquals("center", LatinTranslator.translate("medium"));
	}

	@Test
	public void testCaseIsInsensitive(){
		assertEquals("center", LatinTranslator.translate("MeDIUM"));
	}

	@Test
	public void testThatNonsenseWordThrowsException(){
		try{
			LatinTranslator.translate("oijifoiajfeo");
			fail("translate should throw an exception when it gets garbage latin");
		} catch (IllegalArgumentException ex){
			assertNotNull(ex);
		}
	}

}