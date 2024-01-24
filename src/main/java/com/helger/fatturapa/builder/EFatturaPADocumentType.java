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
package com.helger.fatturapa.builder;

import java.util.List;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.string.StringHelper;
import com.helger.fatturapa.CFatturaPA;
import com.helger.fatturapa.v120.FPA120FatturaElettronicaType;
import com.helger.fatturapa.v121.FPA121FatturaElettronicaType;
import com.helger.fatturapa.v122.FPA122FatturaElettronicaType;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;

/**
 * Enumeration with all available fatturaPA document types.
 *
 * @author Philip Helger
 * @since 1.0.1
 */
@Deprecated (forRemoval = true, since = "2.0.3")
public enum EFatturaPADocumentType implements IJAXBDocumentType
{
  FATTURAPA_120 (FPA120FatturaElettronicaType.class, CFatturaPA.getAllXSDFatturaPA120 ()),
  FATTURAPA_121 (FPA121FatturaElettronicaType.class, CFatturaPA.getAllXSDFatturaPA121 ()),
  FATTURAPA_122 (FPA122FatturaElettronicaType.class, CFatturaPA.getAllXSDFatturaPA122 ());

  private final JAXBDocumentType m_aDocType;

  EFatturaPADocumentType (@Nonnull final Class <?> aClass, @Nonnull final List <? extends ClassPathResource> aXSDPaths)
  {
    m_aDocType = new JAXBDocumentType (aClass, aXSDPaths, x -> StringHelper.trimEnd (x, "Type"));
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aDocType.getAllXSDResources ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  @Nonempty
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public Schema getSchema ()
  {
    return m_aDocType.getSchema ();
  }
}
