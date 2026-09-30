/*
 * Copyright (C) 2020-2026 Philip Helger (www.helger.com)
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

import com.helger.annotation.concurrent.NotThreadSafe;
import com.helger.collection.commons.ICommonsList;
import com.helger.fatturapa.v123.FPA123FatturaElettronicaType;
import com.helger.fatturapa.v123.ObjectFactory;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;

/**
 * This is the reader and writer for fatturaPA 1.2.3 documents. This class may be derived to
 * override protected methods from {@link GenericJAXBMarshaller}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class FatturaPA123Marshaller extends GenericJAXBMarshaller <FPA123FatturaElettronicaType>
{
  private static final ICommonsList <ClassPathResource> XSDS = CFatturaPA.getAllXSDFatturaPA123 ();

  public FatturaPA123Marshaller ()
  {
    this (true);
  }

  public FatturaPA123Marshaller (final boolean bValidationEnabled)
  {
    super (FPA123FatturaElettronicaType.class,
           bValidationEnabled ? XSDS : null,
           new ObjectFactory ()::createFatturaElettronica);

    setNamespaceContext (FatturaPA123NamespaceContext.getInstance ());
  }
}
