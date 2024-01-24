/*
 * Copyright (C) 2020-2024 Philip Helger (www.helger.com)
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

import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.fatturapa.v122.FPA122FatturaElettronicaType;
import com.helger.fatturapa.v122.ObjectFactory;
import com.helger.jaxb.GenericJAXBMarshaller;

/**
 * This is the reader and writer for fatturaPA 1.2.2 documents. This class may
 * be derived to override protected methods from {@link GenericJAXBMarshaller}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class FatturaPA122Marshaller extends GenericJAXBMarshaller <FPA122FatturaElettronicaType>
{
  private static final ICommonsList <ClassPathResource> XSDS = CFatturaPA.getAllXSDFatturaPA122 ();

  public FatturaPA122Marshaller ()
  {
    this (true);
  }

  public FatturaPA122Marshaller (final boolean bValidationEnabled)
  {
    super (FPA122FatturaElettronicaType.class,
           bValidationEnabled ? XSDS : null,
           new ObjectFactory ()::createFatturaElettronica);

    setNamespaceContext (FatturaPA122NamespaceContext.getInstance ());
  }
}
