/*
 * Copyright (C) 2020-2025 Philip Helger (www.helger.com)
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

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.PresentForCodeCoverage;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.xsds.xmldsig.CXMLDSig;

import jakarta.annotation.Nonnull;

/**
 * Contains all the constants for FatturaPA handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CFatturaPA
{
  public static final String DEFAULT_PREFIX_FPA = "p";
  public static final String NAMESPACE_URI_FATTURA_PA_120 = "http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2";
  public static final String NAMESPACE_URI_FATTURA_PA_121 = NAMESPACE_URI_FATTURA_PA_120;
  public static final String NAMESPACE_URI_FATTURA_PA_122 = NAMESPACE_URI_FATTURA_PA_120;

  @Nonnull
  private static ClassLoader _getCL ()
  {
    return CFatturaPA.class.getClassLoader ();
  }

  /**
   * @return A list of all includes in the correct order. Never
   *         <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDIncludes ()
  {
    return new CommonsArrayList <> (CXMLDSig.getXSDResource ());
  }

  // Note: requires XMLDsig
  @Nonnull
  public static ClassPathResource getXSDFatturaPA120 ()
  {
    return new ClassPathResource ("/external/schemas/fatturapa/Schema_del_file_xml_FatturaPA_versione_1.2.xsd",
                                  _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDFatturaPA120 ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDFatturaPA120 ());
    return ret;
  }

  // Note: requires XMLDsig
  @Nonnull
  public static ClassPathResource getXSDFatturaPA121 ()
  {
    return new ClassPathResource ("/external/schemas/fatturapa/Schema_del_file_xml_FatturaPA_versione_1.2.1.xsd",
                                  _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDFatturaPA121 ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDFatturaPA121 ());
    return ret;
  }

  // Note: requires XMLDsig
  @Nonnull
  public static ClassPathResource getXSDFatturaPA122 ()
  {
    return new ClassPathResource ("/external/schemas/fatturapa/Schema_del_file_xml_FatturaPA_v1.2.2.xsd", _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDFatturaPA122 ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDFatturaPA122 ());
    return ret;
  }

  @PresentForCodeCoverage
  private static final CFatturaPA INSTANCE = new CFatturaPA ();

  private CFatturaPA ()
  {}
}
