package eu.openvalue.domain.entity;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.EmbeddableInstantiator;

@Embeddable
//@EmbeddableInstantiator(AddressInstantiator.class)
public record Address(String street, String city, int postalCode) {
}