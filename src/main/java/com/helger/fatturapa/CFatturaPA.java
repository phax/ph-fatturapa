/*
 * Copyright (C) 2020-2022 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xsds.xmldsig.CXMLDSig;

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
  public static final String NAMESPACE_URI_FATTURA_PA_121 = "http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2";

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
    return new ClassPathResource ("/schemas/fatturapa/Schema_del_file_xml_FatturaPA_versione_1.2.xsd", _getCL ());
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
    return new ClassPathResource ("/schemas/fatturapa/Schema_del_file_xml_FatturaPA_versione_1.2.1.xsd", _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDFatturaPA121 ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDFatturaPA121 ());
    return ret;
  }

  @PresentForCodeCoverage
  private static final CFatturaPA s_aInstance = new CFatturaPA ();

  private CFatturaPA ()
  {}
}
