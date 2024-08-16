/*
 * Copyright 2013-2024 consulo.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package consulo.java.jackson;

import com.intellij.java.language.codeInsight.AnnotationUtil;
import com.intellij.java.language.psi.PsiModifierListOwner;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.editor.ImplicitUsageProvider;
import consulo.language.psi.PsiElement;

import java.util.Set;

/**
 * @author VISTALL
 * @since 2024-08-16
 */
@ExtensionImpl
public class JacksonImplicitUsageProvider implements ImplicitUsageProvider {
    private static final Set<String> ImplicitUsages = Set.of(
        JacksonAnnotations.JsonCreator,
        JacksonAnnotations.JsonAnyGetter,
        JacksonAnnotations.JsonAnySetter
    );

    @Override
    public boolean isImplicitUsage(PsiElement element) {
        return element instanceof PsiModifierListOwner owner && AnnotationUtil.isAnnotated(owner, ImplicitUsages, 0);
    }
}
