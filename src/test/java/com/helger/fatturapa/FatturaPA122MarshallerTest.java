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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.io.file.FileSystemIterator;

/**
 * Test class for class {@link FatturaPA122Marshaller}.
 *
 * @author Philip Helger
 */
public final class FatturaPA122MarshallerTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (FatturaPA122MarshallerTest.class);

  @Test
  public void testReadGood ()
  {
    LOGGER.info ("Reading good fatturaPA files");
    final FatturaPA122Marshaller aMarshaller = new FatturaPA122Marshaller ();
    for (final File aFile : new FileSystemIterator ("src/test/resources/external/examples/122/good"))
      if (aFile.isFile ())
        assertNotNull (aFile.getAbsolutePath (), aMarshaller.read (aFile));
  }

  @Test
  public void testReadBad ()
  {
    LOGGER.info ("Reading bad fatturaPA files");
    final FatturaPA122Marshaller aMarshaller = new FatturaPA122Marshaller ();
    for (final File aFile : new FileSystemIterator ("src/test/resources/external/examples/122/bad"))
      if (aFile.isFile ())
        assertNull (aFile.getAbsolutePath (), aMarshaller.read (aFile));
  }
}
