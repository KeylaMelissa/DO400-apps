package com.redhat.shopping.catalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class CatalogService implements Catalog {

    @Inject
    CatalogStorage storage;

    public CatalogService() {
    }

    public CatalogService(CatalogStorage storage) {
        this.storage = storage;
    }

    @Override
    public Collection<Product> getAll() {
        return this.storage.getAll();
    }

    @Override
    public Product ofId(int id) throws ProductNotFoundInCatalogException {
        if (!this.storage.containsKey(id)) {
            throw ProductNotFoundInCatalogException.ofId(id);
        }
        return this.storage.get(id);
    }
}