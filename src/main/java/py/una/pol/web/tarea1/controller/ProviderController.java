package py.una.pol.web.tarea1.controller;

import py.una.pol.web.tarea1.model.Item;
import py.una.pol.web.tarea1.model.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by codiumsa on 27/2/16.
 */
public class ProviderController {
    private static ProviderController instance = new ProviderController();
    private Integer sequence = 1;
    private List<Provider> providers = new ArrayList<Provider>();

    private ProviderController() {
        //Mock provider
        Provider p = new Provider();
        p.setName("Distribuidora Gloria");
        this.addProvider(p);
    }

    public static ProviderController getInstance() {
        return instance;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void addProvider(Provider p) {
        p.setId(sequence++);
        this.providers.add(p);
    }

    public Provider getProvider(Integer id) {
        for(Provider p : providers) {
            if(p.getId() != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Provider updateProvider(Integer id, Provider providerWithChanges) {
        for(Provider p : providers) {
            if(p.getId() != null && p.getId().equals(id)) {
                if(providerWithChanges.getName() != null) {
                    p.setName(providerWithChanges.getName());
                }

                return p;
            }
        }
        return null;
    }

    public void removeProvider(final Integer id) {
        providers.removeIf(new Predicate<Provider>() {
            public boolean test(Provider provider) {
                if(provider.getId() != null && provider.getId().equals(id)) {
                    return true;
                }
                return false;
            }
        });
    }

}