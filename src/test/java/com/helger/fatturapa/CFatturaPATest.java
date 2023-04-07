/*
 * Copyright (C) 2020-2023 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.fatturapa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import javax.xml.validation.Schema;

import org.junit.Test;

import com.helger.xml.schema.XMLSchemaCache;

/**
 * Test class for class {@link CFatturaPA}.
 *
 * @author Philip Helger
 */
public final class CFatturaPATest
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CFatturaPA.getXSDFatturaPA120 ());
    assertTrue (CFatturaPA.getXSDFatturaPA120 ().exists ());
    assertEquals (CFatturaPA.getXSDFatturaPA120 (), CFatturaPA.getXSDFatturaPA120 ());
    assertNotSame (CFatturaPA.getXSDFatturaPA120 (), CFatturaPA.getXSDFatturaPA120 ());

    assertNotNull (CFatturaPA.getXSDFatturaPA121 ());
    assertTrue (CFatturaPA.getXSDFatturaPA121 ().exists ());
    assertEquals (CFatturaPA.getXSDFatturaPA121 (), CFatturaPA.getXSDFatturaPA121 ());
    assertNotSame (CFatturaPA.getXSDFatturaPA121 (), CFatturaPA.getXSDFatturaPA121 ());

    assertNotNull (CFatturaPA.getXSDFatturaPA122 ());
    assertTrue (CFatturaPA.getXSDFatturaPA122 ().exists ());
    assertEquals (CFatturaPA.getXSDFatturaPA122 (), CFatturaPA.getXSDFatturaPA122 ());
    assertNotSame (CFatturaPA.getXSDFatturaPA122 (), CFatturaPA.getXSDFatturaPA122 ());
  }

  @Test
  public void testSchemaCreation1 ()
  {
    Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (CFatturaPA.getAllXSDFatturaPA120 ());
    assertNotNull (aSchema);

    aSchema = XMLSchemaCache.getInstance ().getFromCache (CFatturaPA.getAllXSDFatturaPA121 ());
    assertNotNull (aSchema);
  }
}
