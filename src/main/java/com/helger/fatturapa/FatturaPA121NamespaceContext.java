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

import com.helger.annotation.misc.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;

import jakarta.annotation.Nonnull;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class FatturaPA121NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final FatturaPA121NamespaceContext INSTANCE = new FatturaPA121NamespaceContext ();
  }

  protected FatturaPA121NamespaceContext ()
  {
    addMapping (CXMLDSig.DEFAULT_PREFIX, CXMLDSig.NAMESPACE_URI);
    addMapping (CFatturaPA.DEFAULT_PREFIX_FPA, CFatturaPA.NAMESPACE_URI_FATTURA_PA_121);
  }

  @Nonnull
  public static FatturaPA121NamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
