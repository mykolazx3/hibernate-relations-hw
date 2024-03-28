package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.exception.DataProcessingException;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;

public class ActorServiceImpl implements ActorService {
    private ActorDao actorDao;

    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public Actor add(Actor actor) {
        if (actor == null) {
            throw new DataProcessingException("ERROR: The actor is null!");
        }
        return actorDao.add(actor);
    }

    @Override
    public Actor get(Long id) {
        if (id == null) {
            throw new DataProcessingException("ERROR: The id is null!");
        }
        return actorDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't get a actor by id: " + id));
    }
}
