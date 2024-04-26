package eu.openvalue.domain.entity;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.EmbeddableInstantiator;
import org.hibernate.metamodel.spi.ValueAccess;

public class AddressInstantiator implements EmbeddableInstantiator {
  @Override
  public Object instantiate(final ValueAccess valueAccess, final SessionFactoryImplementor sessionFactoryImplementor) {
    // valuesAccess contains attribute values in alphabetical order
    final String city = valueAccess.getValue(0, String.class);
    final Integer postalCode = valueAccess.getValue(1, Integer.class);
    final String street = valueAccess.getValue(2, String.class);
    return new Address( street, city, postalCode );
  }

  @Override
  public boolean isInstance(final Object o, final SessionFactoryImplementor sessionFactoryImplementor) {
    return o instanceof Address;
  }

  @Override
  public boolean isSameClass(final Object o, final SessionFactoryImplementor sessionFactoryImplementor) {
    return Address.class.equals(o.getClass());
  }
}