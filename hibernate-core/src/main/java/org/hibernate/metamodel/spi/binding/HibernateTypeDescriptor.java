/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.spi.binding;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.metamodel.spi.domain.JavaClassReference;
import org.hibernate.type.Type;

/**
 * TODO : javadoc
 *
 * @author Steve Ebersole
 */
public class HibernateTypeDescriptor {
	private String explicitTypeName;
	private Map<String, String> typeParameters = new HashMap<String, String>(  );

	private Type resolvedTypeMapping;
	private JavaClassReference javaClassReference;

	public String getExplicitTypeName() {
		return explicitTypeName;
	}

	public void setExplicitTypeName(String explicitTypeName) {
		this.explicitTypeName = explicitTypeName;
	}

	public JavaClassReference getClassReference() {
		return javaClassReference;
	}

	public void setClassReference(JavaClassReference javaClassReference) {
		this.javaClassReference = javaClassReference;
	}

	public boolean isToOne() {
		return resolvedTypeMapping.isEntityType();
	}

	public Map<String, String> getTypeParameters() {
		return typeParameters;
	}

	public Type getResolvedTypeMapping() {
		return resolvedTypeMapping;
	}

	public void setResolvedTypeMapping(Type resolvedTypeMapping) {
		this.resolvedTypeMapping = resolvedTypeMapping;
	}

	public void copyFrom(HibernateTypeDescriptor hibernateTypeDescriptor) {
		setClassReference( hibernateTypeDescriptor.getClassReference() );
		setExplicitTypeName( hibernateTypeDescriptor.getExplicitTypeName() );
		getTypeParameters().putAll( hibernateTypeDescriptor.getTypeParameters() );
		setResolvedTypeMapping( hibernateTypeDescriptor.getResolvedTypeMapping() );
	}
}
